package domain;

public class Cow {

    private int cowId;
    private String nickName;

    public Cow(int cowId) {
        this.cowId = cowId;
    }

    public Cow(int cowId, String nickName) {
        this.cowId = cowId;
        this.nickName = nickName;
    }

    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return this.getNickName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cow cow = (Cow) o;

        return cowId == cow.cowId;
    }

    @Override
    public int hashCode() {
        return cowId;
    }
}
