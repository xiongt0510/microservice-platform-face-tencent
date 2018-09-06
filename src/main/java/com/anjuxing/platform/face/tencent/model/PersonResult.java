package com.anjuxing.platform.face.tencent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author xiongt
 * @Description
 */
public class PersonResult implements Serializable{

        @JsonProperty("person_id")
        private String personId;

        @JsonProperty("face_id")
        private String faceId;


        @JsonProperty("group_ids")
        private String[] groupIds;


        private String message;

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getFaceId() {
            return faceId;
        }

        public void setFaceId(String faceId) {
            this.faceId = faceId;
        }

        public String[] getGroupIds() {
            return groupIds;
        }

        public void setGroupIds(String[] groupIds) {
            this.groupIds = groupIds;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
}
