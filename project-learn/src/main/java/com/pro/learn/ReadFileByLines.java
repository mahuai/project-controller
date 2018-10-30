package com.pro.learn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn
 * @date: Created in 2018/9/13  15:05
 */
public class ReadFileByLines {

    public static void main(String[] args) {
        try{

            //1.打开一个file
            File file = new File("D:/0BD7A8FCB0E2369F07023F1AC62FCDE0");
            //2.InputStreamReader<-FileInputStream<-file
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader is = new InputStreamReader(fis,"UTF-8");
            //3.用BufferedReader(<-InputStreamReader)的readLine()方法读取
            BufferedReader br = new BufferedReader(is);
            //4.输出
            String txtLine = null;
            while((txtLine=br.readLine())!=null){
                System.out.println(txtLine);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
