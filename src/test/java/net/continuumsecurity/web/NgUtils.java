package net.continuumsecurity.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NgUtils {
 
  public static List<String> createListOfValues(String pathToTable) {
    BufferedReader br = null;
    List<String> ls = new ArrayList<String>();
    try {
      br = new BufferedReader(new FileReader(pathToTable));
      String line = br.readLine();
      while (line != null) {
        line = line.replace("|","");
        ls.add(line);
        line = br.readLine();
      }
    }catch (Exception e){
      e.printStackTrace();
    } finally {
      try{
        if (br != null){
          br.close();
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    return ls;
  }
  
  public static List<HashMap> createListOfMaps(String pathToTable) {
    BufferedReader br = null;
    List<HashMap> listMap = new ArrayList<HashMap>();
    try {
      br = new BufferedReader(new FileReader(pathToTable));
      String line = br.readLine();
      String[] firstLine = line.split("\\|");
      line = br.readLine();
      while (line != null) {
        String[] lineList = line.split("\\|");
        HashMap map = new HashMap();
        int i = 0;
        for(String item: lineList){
          map.put(firstLine[i],item);
          i = i + 1;
        }
        listMap.add(map);
        line = br.readLine();
      }
    }catch (Exception e){
      e.printStackTrace();
    } finally {
      try{
        if (br != null){
          br.close();
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    return listMap;
  }

  public static String createStringFromJBehaveTable(String pathToTable){
    String jbehaveTable;
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(pathToTable));
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();
      while (line != null) {
          sb.append(line);
          sb.append("\n");
          line = br.readLine();
      }
      jbehaveTable = sb.toString();
    }catch (Exception e){
      jbehaveTable = "";
      e.printStackTrace();
    } finally {
      try{
        if (br != null){
          br.close();
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    return jbehaveTable;
  }
}
