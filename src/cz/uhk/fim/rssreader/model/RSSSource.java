package cz.uhk.fim.rssreader.model;

public class RSSSource {
    private String name, source;
    public RSSSource(){}
    public RSSSource(String name, String source){
        this.name = name;
        this.source = source;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String getSource(){
        return source;
    }
}
