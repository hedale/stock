package com.xc.utils.stock.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.*;

public class GetPyByChinese {
    public static void main(String[] args) {
        System.out.println(converterToFirstSpell("长沙市长"));
        System.out.println(converterToFirstSpell("平安银行"));
        System.out.println(converterToFirstSpell("老板电器"));
    }

    public static String converterToFirstSpell(String chines) {
        StringBuffer pinyinName = new StringBuffer();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > '') {
                try {
                    String[] strs = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
                    if (strs != null) {
                        for (int j = 0; j < strs.length; j++) {
                            pinyinName.append(strs[j].charAt(0));
                            if (j != strs.length - 1) {
                                pinyinName.append(",");
                            }
                        }
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(nameChar[i]);
            }
            pinyinName.append(" ");
        }
        return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));
    }

    private static List<Map<String, Integer>> discountTheChinese(String theStr) {
        List<Map<String, Integer>> mapList = new ArrayList();
        Map<String, Integer> onlyOne = null;
        String[] firsts = theStr.split(" ");
        for (String str : firsts) {
            onlyOne = new Hashtable();
            String[] china = str.split(",");
            for (String s : china) {
                Integer count = (Integer) onlyOne.get(s);
                if (count == null) {
                    onlyOne.put(s, 1);
                } else {
                    onlyOne.remove(s);
                    Integer integer1 = count;
                    Integer integer2 = count = Integer.valueOf(count.intValue() + 1);
                    onlyOne.put(s, count);
                }
            }
            mapList.add(onlyOne);
        }
        return mapList;
    }

    private static String parseTheChineseByObject(List<Map<String, Integer>> list) {
        Map<String, Integer> first = null;
        Map<String, Integer> temp;
      for (Map<String, Integer> stringIntegerMap : list) {
        temp = new Hashtable();
        Iterator localIterator1;
        if (first != null) {
          for (localIterator1 = first.keySet().iterator(); localIterator1.hasNext(); ) {
            String s = (String) localIterator1.next();
            for (Object s1 : ((Map) stringIntegerMap).keySet()) {
              String str = s + s1;
              temp.put(str, Integer.valueOf(1));
            }
          }
          if (temp.size() > 0) {
            first.clear();
          }
        } else {
          for (Object s : ((Map) stringIntegerMap).keySet()) {
            String str = (String) s;
            temp.put(str, Integer.valueOf(1));
          }
        }
        if (temp.size() > 0) {
          first = temp;
        }
      }
        String returnStr = "";
        if (first != null) {
            for (String str : first.keySet()) {
                returnStr = returnStr + str + ",";
            }
        }
        if (returnStr.length() > 0) {
            returnStr = returnStr.substring(0, returnStr.length() - 1);
        }
        return returnStr;
    }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.stock.pinyin.GetPyByChinese

 * JD-Core Version:    0.7.0.1

 */