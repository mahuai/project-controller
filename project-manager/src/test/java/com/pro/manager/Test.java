package com.pro.manager;

import java.io.*;

/**
 * @author ms
 * @Description:
 * @Package com.pro.manager
 * @date: Created in 2018/7/13 14:31
 */

public class Test {


    public static void main(String[] args) throws IOException {
//        createByteStream();
//        createWriter();

        /*String str="中";
        byte [] b_gbk=str.getBytes("GBK");
        byte [] b_utf=str.getBytes("UTF-8");
        byte [] b_unic=str.getBytes("UTF-16");
        byte [] b_Iso=str.getBytes("ISO8859-1");
        System.out.println(b_gbk);
        System.out.println(b_utf);
        System.out.println(b_unic);
        System.out.println(b_Iso);*/




    }



    public static void createByteStream() throws IOException {
        File file = new File("D:/ByteStream/text.txt");
        OutputStream stream = new FileOutputStream(file);
        String str = "字节流";
        byte[] b = str.getBytes();
        stream.write(b);
    }

    public static void createWriter() throws IOException {
        File file = new File("D:/ByteStream/text.txt");
        Writer writer = new FileWriter(file);
        String str = "字符流";
//        byte[] b=str.getBytes();
        writer.write(str);
        writer.close();
    }


    public static void pipedReader() throws IOException {


    }
}
