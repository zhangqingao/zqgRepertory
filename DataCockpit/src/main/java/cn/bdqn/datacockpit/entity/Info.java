package cn.bdqn.datacockpit.entity;

import java.util.Date;

/**
 * 
 * Description: 通知类<br/>
 * date: 2017年8月21日 上午11:05:41 <br/>
 *
 * @author caoS
 * @version
 */
public class Info {
    private Integer id;//主键id

    private String title;

    private Date publishdate;

    private String details;

    private String publisher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}