package me.khabib.garmin2doist.entities.todoist;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "project_id",
        "section_id",
        "order",
        "content",
        "completed",
        "label_ids",
        "priority",
        "comment_count",
        "created",
        "due",
        "url"
})
public class SavedTask {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("project_id")
    private Long projectId;
    @JsonProperty("section_id")
    private Long sectionId;
    @JsonProperty("order")
    private Long order;
    @JsonProperty("content")
    private String content;
    @JsonProperty("completed")
    private Boolean completed;
    @JsonProperty("label_ids")
    private List<Object> labelIds = null;
    @JsonProperty("priority")
    private Long priority;
    @JsonProperty("comment_count")
    private Long commentCount;
    @JsonProperty("created")
    private String created;
    @JsonProperty("due")
    private Due due;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("project_id")
    public Long getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("section_id")
    public Long getSectionId() {
        return sectionId;
    }

    @JsonProperty("section_id")
    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    @JsonProperty("order")
    public Long getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Long order) {
        this.order = order;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("completed")
    public Boolean getCompleted() {
        return completed;
    }

    @JsonProperty("completed")
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @JsonProperty("label_ids")
    public List<Object> getLabelIds() {
        return labelIds;
    }

    @JsonProperty("label_ids")
    public void setLabelIds(List<Object> labelIds) {
        this.labelIds = labelIds;
    }

    @JsonProperty("priority")
    public Long getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @JsonProperty("comment_count")
    public Long getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("due")
    public Due getDue() {
        return due;
    }

    @JsonProperty("due")
    public void setDue(Due due) {
        this.due = due;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}