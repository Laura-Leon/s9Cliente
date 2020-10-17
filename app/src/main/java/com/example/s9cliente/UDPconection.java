package com.example.s9cliente;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPconection extends Thread {

    private DatagramSocket socket;

    public void run () {
        try {

            // escucha
            socket = new DatagramSocket(6000);
            // espera mensaje

            while (true) {
                byte [ ] buffer = new byte[100];
                DatagramPacket packet = new DatagramPacket (buffer,buffer.length);
                Log.e(" --","Esperando datagrama");
                socket.receive(packet);

                String mensaje = new String (packet.getData()).trim();

               Log.e("--", "Datagrama recibito"+ mensaje);
            }






        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendMessage(String mensaje) {
        new Thread (
                ()->{

                    try {
                        InetAddress ip = InetAddress.getByName("192.168.0.6");
                        DatagramPacket packet = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,ip,5000);
                        socket.send(packet);
                    } catch (UnknownHostException e) {

                        e.printStackTrace();
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                }

        ).start();

    }

}
