public void GETMUltitest() {
        try {
            MulticastSocket multicastSocket = new MulticastSocket();
           // multicastSocket.joinGroup(InetAddress.getByName("229.1.1.2"));
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            Log.d(TAG,"ready to start");
            multicastSocket.connect(InetAddress.getByName("229.1.1.2"),5565);
            Boolean bean= multicastSocket.isConnected();
            if( bean == false){
                Log.d(TAG,"not connect ");
                return;
            }
            multicastSocket.receive(packet);
            byte[] data = packet.getData();
            int length = packet.getLength();
            String str = new String(data,"UTF-8");
            Log.d(TAG,"data is " + str +"  length="+ length);
        } catch (IOException e) {
            Log.d(TAG,"i do not know what error");
            e.printStackTrace();
            return;
        }
    }
