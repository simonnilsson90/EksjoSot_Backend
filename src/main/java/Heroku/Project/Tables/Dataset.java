package Heroku.Project.Tables;

import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.security.Permissions;
import java.time.LocalDateTime;

@Entity
@Table(name = "datasets")

public class Dataset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "permissionsId", nullable = false)

   private Permission permissionId;

    @Override
    public String toString() {
        return "Dataset{" +
                "datasetId=" + datasetId +
                ", user=" + user +
                ", permission=" + permissionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", uploadDate=" + uploadDate +
                ", fileSize=" + fileSize +
                ", previewURL='" + previewURL + '\'' +
                '}';
    }

    public Long getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Long datasetId) {
        this.datasetId = datasetId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermission(Permission permission) {
        this.permissionId = permission;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    private String title;
    private String description;
    private String category;
    private BigDecimal price;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime uploadDate;

    private Integer fileSize;
    private String previewURL;
}
