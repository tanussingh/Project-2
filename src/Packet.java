import java.io.Serializable;

public class Packet implements Serializable {
    private int broadcastNode;
    private int sourceId;
    private String msg;

    public void buildPacket(int sourceId, String msg) {
        this.sourceId = sourceId;
        this.msg = msg;
    }

    public void setBroadcastNode(int num) {
        this.broadcastNode = num;
    }

    public int getBroadcastNode() {
        return this.broadcastNode;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "Message [sourceId=" + sourceId + ", msg=" + this.msg + "]";
    }
}