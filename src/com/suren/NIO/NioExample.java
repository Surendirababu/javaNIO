package com.suren.NIO;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Surendirababu Janarthanan on 6/22/2017.
 */
public class NioExample {


    //Reading file contents from file using NIO.
    public static void main(String a[]) {
        try {
            File file = new File("I:\\babu\\workspace\\JavaNIO\\src\\resources\\testNIO.txt");

            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            int bytesRead = fileChannel.read(byteBuffer);
            List<Character> characterList = new ArrayList<>();
            while (bytesRead != -1) {
                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    characterList.add(((char) byteBuffer.get()));
                }
                byteBuffer.clear();
                bytesRead = fileChannel.read(byteBuffer);
            }
            characterList.forEach(character -> System.out.print(character));
            fileChannel.close();
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
