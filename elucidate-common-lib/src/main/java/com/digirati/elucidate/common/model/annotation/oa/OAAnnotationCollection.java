package com.digirati.elucidate.common.model.annotation.oa;

import java.io.Serializable;

import com.digirati.elucidate.common.model.annotation.AbstractAnnotationCollection;

@SuppressWarnings("serial")
public class OAAnnotationCollection extends AbstractAnnotationCollection implements Serializable {

    @Override
    public String toString() {
        return "OAAnnotationCollection [getCollectionId()=" + getCollectionId() + ", isDeleted()=" + isDeleted() + ", getCreatedDateTime()=" + getCreatedDateTime() + ", getModifiedDateTime()=" + getModifiedDateTime() + ", getCacheKey()=" + getCacheKey() + "]";
    }
}
