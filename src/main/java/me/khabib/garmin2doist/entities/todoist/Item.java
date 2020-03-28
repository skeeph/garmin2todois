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
        "legacy_project_id",
        "day_order",
        "assigned_by_uid",
        "labels",
        "sync_id",
        "section_id",
        "in_history",
        "child_order",
        "date_added",
        "id",
        "content",
        "checked",
        "added_by_uid",
        "user_id",
        "due",
        "priority",
        "parent_id",
        "is_deleted",
        "responsible_uid",
        "project_id",
        "date_completed",
        "collapsed"
})
public class Item {

    @JsonProperty("legacy_project_id")
    private long legacyProjectId;
    @JsonProperty("day_order")
    private long dayOrder;
    @JsonProperty("assigned_by_uid")
    private Object assignedByUid;
    @JsonProperty("labels")
    private List<Object> labels = null;
    @JsonProperty("sync_id")
    private Object syncId;
    @JsonProperty("section_id")
    private Object sectionId;
    @JsonProperty("in_history")
    private long inHistory;
    @JsonProperty("child_order")
    private long childOrder;
    @JsonProperty("date_added")
    private String dateAdded;
    @JsonProperty("id")
    private long id;
    @JsonProperty("content")
    private String content;
    @JsonProperty("checked")
    private long checked;
    @JsonProperty("added_by_uid")
    private long addedByUid;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("due")
    private Due due;
    @JsonProperty("priority")
    private long priority;
    @JsonProperty("parent_id")
    private Object parentId;
    @JsonProperty("is_deleted")
    private long isDeleted;
    @JsonProperty("responsible_uid")
    private Object responsibleUid;
    @JsonProperty("project_id")
    private long projectId;
    @JsonProperty("date_completed")
    private Object dateCompleted;
    @JsonProperty("collapsed")
    private long collapsed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("legacy_project_id")
    public long getLegacyProjectId() {
        return legacyProjectId;
    }

    @JsonProperty("legacy_project_id")
    public void setLegacyProjectId(long legacyProjectId) {
        this.legacyProjectId = legacyProjectId;
    }

    @JsonProperty("day_order")
    public long getDayOrder() {
        return dayOrder;
    }

    @JsonProperty("day_order")
    public void setDayOrder(long dayOrder) {
        this.dayOrder = dayOrder;
    }

    @JsonProperty("assigned_by_uid")
    public Object getAssignedByUid() {
        return assignedByUid;
    }

    @JsonProperty("assigned_by_uid")
    public void setAssignedByUid(Object assignedByUid) {
        this.assignedByUid = assignedByUid;
    }

    @JsonProperty("labels")
    public List<Object> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    @JsonProperty("sync_id")
    public Object getSyncId() {
        return syncId;
    }

    @JsonProperty("sync_id")
    public void setSyncId(Object syncId) {
        this.syncId = syncId;
    }

    @JsonProperty("section_id")
    public Object getSectionId() {
        return sectionId;
    }

    @JsonProperty("section_id")
    public void setSectionId(Object sectionId) {
        this.sectionId = sectionId;
    }

    @JsonProperty("in_history")
    public long getInHistory() {
        return inHistory;
    }

    @JsonProperty("in_history")
    public void setInHistory(long inHistory) {
        this.inHistory = inHistory;
    }

    @JsonProperty("child_order")
    public long getChildOrder() {
        return childOrder;
    }

    @JsonProperty("child_order")
    public void setChildOrder(long childOrder) {
        this.childOrder = childOrder;
    }

    @JsonProperty("date_added")
    public String getDateAdded() {
        return dateAdded;
    }

    @JsonProperty("date_added")
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("checked")
    public long getChecked() {
        return checked;
    }

    @JsonProperty("checked")
    public void setChecked(long checked) {
        this.checked = checked;
    }

    @JsonProperty("added_by_uid")
    public long getAddedByUid() {
        return addedByUid;
    }

    @JsonProperty("added_by_uid")
    public void setAddedByUid(long addedByUid) {
        this.addedByUid = addedByUid;
    }

    @JsonProperty("user_id")
    public long getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty("due")
    public Due getDue() {
        return due;
    }

    @JsonProperty("due")
    public void setDue(Due due) {
        this.due = due;
    }

    @JsonProperty("priority")
    public long getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(long priority) {
        this.priority = priority;
    }

    @JsonProperty("parent_id")
    public Object getParentId() {
        return parentId;
    }

    @JsonProperty("parent_id")
    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    @JsonProperty("is_deleted")
    public long getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("is_deleted")
    public void setIsDeleted(long isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("responsible_uid")
    public Object getResponsibleUid() {
        return responsibleUid;
    }

    @JsonProperty("responsible_uid")
    public void setResponsibleUid(Object responsibleUid) {
        this.responsibleUid = responsibleUid;
    }

    @JsonProperty("project_id")
    public long getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("date_completed")
    public Object getDateCompleted() {
        return dateCompleted;
    }

    @JsonProperty("date_completed")
    public void setDateCompleted(Object dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    @JsonProperty("collapsed")
    public long getCollapsed() {
        return collapsed;
    }

    @JsonProperty("collapsed")
    public void setCollapsed(long collapsed) {
        this.collapsed = collapsed;
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
