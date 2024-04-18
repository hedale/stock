package com.xc.config;

import com.xc.dao.RealTimeMapper;
import com.xc.dao.StockFuturesMapper;
import com.xc.dao.StockIndexMapper;
import com.xc.dao.StockMapper;
import com.xc.pojo.Stock;
import com.xc.pojo.StockFutures;
import com.xc.pojo.StockIndex;
import com.xc.utils.stock.BuyAndSellUtils;
import com.xc.utils.stock.sina.SinaStockApi;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

@Component
public class StockPoll {
    @Resource
    StockMapper stockMapper;
    @Resource
    RealTimeMapper realTimeMapper;
    @Resource
    StockFuturesMapper stockFuturesMapper;
    @Resource
    StockIndexMapper stockIndexMapper;
    private ThreadPoolExecutor pool;

    @PostConstruct
    public void initPool() {
        this.pool = new ThreadPoolExecutor(50, 70, 20L, TimeUnit.SECONDS, new ArrayBlockingQueue(240));
        this.pool.setRejectedExecutionHandler(new DiscardOldestPolicy());
    }

    public void test(String stockType, Integer stock_num, Integer stock_nums) {
        List<Stock> stockCodes = this.stockMapper.findStockCode(stockType, stock_num, stock_nums);
        System.out.println("stockCodes" + stockCodes.size() + "--stockCodes");
        for (Stock stock : stockCodes) {
            String stockGid = stock.getStockGid();
            String sinaStock = SinaStockApi.getSinaStock("s_" + stockGid);
            String[] arrayOfString = sinaStock.split(",");
            StockTask stockTask = new StockTask();
            stockTask.splits((Object[]) arrayOfString);
            stockTask.stockGid(stockGid);


            stockTask.averagePrice(Double.valueOf(Double.parseDouble("0")));
            stockTask.StockPoll(this);
            stockTask.RealTimeMapper(this.realTimeMapper);

            this.pool.submit(stockTask);
        }
    }

    public void z1() {
        test("sz", Integer.valueOf(0), Integer.valueOf(200));
    }

    public void z11() {
        test("sz", Integer.valueOf(200), Integer.valueOf(200));
    }

    public void z12() {
        test("sz", Integer.valueOf(400), Integer.valueOf(140));
    }

    public void z2() {
        test("sz", Integer.valueOf(540), Integer.valueOf(200));
    }

    public void z21() {
        test("sz", Integer.valueOf(740), Integer.valueOf(200));
    }

    public void z22() {
        test("sz", Integer.valueOf(940), Integer.valueOf(140));
    }

    public void z3() {
        test("sz", Integer.valueOf(1080), Integer.valueOf(200));
    }

    public void z31() {
        test("sz", Integer.valueOf(1280), Integer.valueOf(200));
    }

    public void z32() {
        test("sz", Integer.valueOf(1480), Integer.valueOf(140));
    }

    public void z4() {
        test("sz", Integer.valueOf(1620), Integer.valueOf(200));
    }

    public void z41() {
        test("sz", Integer.valueOf(1820), Integer.valueOf(200));
    }

    public void z42() {
        test("sz", Integer.valueOf(2020), Integer.valueOf(139));
    }

    public void h1() {
        test("sh", Integer.valueOf(0), Integer.valueOf(200));
    }

    public void h11() {
        test("sh", Integer.valueOf(200), Integer.valueOf(200));
    }

    public void h12() {
        test("sh", Integer.valueOf(400), Integer.valueOf(84));
    }

    public void h2() {
        test("sh", Integer.valueOf(484), Integer.valueOf(200));
    }

    public void h21() {
        test("sh", Integer.valueOf(684), Integer.valueOf(200));
    }

    public void h22() {
        test("sh", Integer.valueOf(884), Integer.valueOf(84));
    }

    public void h3() {
        test("sh", Integer.valueOf(968), Integer.valueOf(200));
    }

    public void h31() {
        test("sh", Integer.valueOf(1168), Integer.valueOf(200));
    }

    public void h32() {
        test("sh", Integer.valueOf(1368), Integer.valueOf(85));
    }

    public void qh1() {
        qhDataGrab("qh", Integer.valueOf(0), Integer.valueOf(540));
    }

    public void qhDataGrab(String stockType, Integer stock_num, Integer stock_nums) {
        List<StockFutures> stockCodes = this.stockFuturesMapper.queryList();
        System.out.println("qh-stockCodes" + stockCodes.size() + "--stockCodes");
        boolean am = false;
        boolean pm = false;
        boolean pm2 = false;
        try {
            am = BuyAndSellUtils.isTransTime("9:15", "12:00");
            pm = BuyAndSellUtils.isTransTime("13:00", "16:30");
            pm2 = BuyAndSellUtils.isTransTime("17:15", "23:45");
        } catch (Exception localException) {
        }
        for (StockFutures stock : stockCodes) {
            String stockGid = stock.getFuturesGid();
            if ((!"hf_HSI".equals(stockGid)) || (am) || (pm) || (pm2)) {
                String sinaStock = SinaStockApi.getSinaStock(stockGid);
                if (sinaStock.length() > 10) {
                    String[] arrayOfString = sinaStock.split(",");
                    if (arrayOfString.length <= 14) {
                        sinaStock = sinaStock.replace("\"", ",1\"");
                        arrayOfString = sinaStock.split(",");
                    }
                    double rates = 0.0D;
                    BigDecimal b1 = new BigDecimal(arrayOfString[3].toString());
                    BigDecimal b2 = new BigDecimal(arrayOfString[4].toString());
                    BigDecimal b3 = b1.subtract(b2);
                    String s = arrayOfString[14].toString();
                    int index = s.indexOf("\"");
                    String substring = s.substring(0, index);
                    rates = b3.multiply(new BigDecimal("100")).divide(b1, 2, 4).doubleValue();
                    String qhstr = "0," + arrayOfString[0].toString() + ",0," + rates + "," + substring + "," + arrayOfString[9].split("\\.")[0].toString() + "\"";
                    String[] arrayqh = qhstr.split(",");
                    StockTask stockTask = new StockTask();
                    stockTask.splits((Object[]) arrayqh);
                    stockTask.stockGid(stockGid);
                    stockTask.averagePrice(0d);
                    stockTask.StockPoll(this);
                    stockTask.RealTimeMapper(this.realTimeMapper);
                    this.pool.submit(stockTask);
                }
            }
        }
    }

    public void zs1() {
        zsDataGrab();
    }

    public void zsDataGrab() {
        List<StockIndex> stockCodes = this.stockIndexMapper.queryListIndex();
        System.out.println("zs-stockCodes" + stockCodes.size() + "--stockCodes");
        for (StockIndex stock : stockCodes) {
            String stockGid = stock.getIndexGid();
            String sinaStock = SinaStockApi.getSinaStock("s_" + stockGid);
            String[] arrayOfString = sinaStock.split(",");
            StockTask stockTask = new StockTask();
            stockTask.splits((Object[]) arrayOfString);
            stockTask.stockGid(stockGid);
            stockTask.StockPoll(this);
            stockTask.RealTimeMapper(this.realTimeMapper);
            this.pool.submit(stockTask);
        }
    }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.config.StockPoll

 * JD-Core Version:    0.7.0.1

 */