package main.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import javafx.scene.control.ListView;
public class Server extends Observable implements Runnable{
    private ServerSocket serverSocket;
    private ListView listView;

    public Server(ServerSocket serverSocket, ListView listView) {
        this.serverSocket = serverSocket;
        this.listView = listView;
    }


    @Override
    public void run() {

        while (!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                this.setChanged();
                this.notifyObservers(socket);
                listView.getItems().add(serverSocket);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}


