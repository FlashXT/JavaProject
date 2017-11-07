package Test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

//中文乱码解决方案：代码如下，请参照
public class TestEncode {

    public static void main(String[] args) throws Exception{ 
        DataOutputStream dos = null; //声明数据输出流对象
        File f = new File("C:\\Users\\Flash_XT\\Desktop" + File.separator + "colorTable.txt");//指定文件的保存路径
        OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
        dos = new DataOutputStream(new FileOutputStream(f));//实例化数据输出流对象   
        String names[] = {"衬衣","手套","围巾"};//商品名称
        float prices[] = {98.3f,30.3f,50.5f};    //商品价格 
        int nums[] = {3,2,1};    //商品数量 
        for(int i = 0;i<names.length;i++){   
            //循环写入   
//            dos.writeChar(names[i]);    //写入字符串
//            dos.writeChar('\t');    //加入分隔符
//            dos.writeFloat(prices[i]);  //写入小数 
//            dos.writeChar('\t'); //加入分隔符  
//            dos.writeInt(nums[i]); //写入整数 
//            dos.writeChar('\n');    //换行
                   
            oStreamWriter.write(names[i]);
            oStreamWriter.write('\t');
            oStreamWriter.write(prices[i]+"     ");  //写入小数 
            oStreamWriter.write('\t'); //加入分隔符
            oStreamWriter.write(nums[i]); //写入整数  
            oStreamWriter.write('\n');  //换行
            }  
            oStreamWriter.close();  //关闭输出流
            dos.close();
    }
    
}