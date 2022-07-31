package Advances.Optional;

// https://www.youtube.com/watch?v=MYXoEU3RkG0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=684

public class Boy {

    private Girl girl;

    public Boy(Girl ann) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

}
