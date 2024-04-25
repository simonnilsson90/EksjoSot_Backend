package Heroku.Project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Datasets")

public class Dataset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DatasetID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;


    @Override
    public String toString() {
        return "Dataset{" +
                "DatasetId=" + DatasetID +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getDatasetID() {
        return DatasetID;
    }

    public void setDatasetID(Long datasetId) {
        this.DatasetID = datasetId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private String title;

}
