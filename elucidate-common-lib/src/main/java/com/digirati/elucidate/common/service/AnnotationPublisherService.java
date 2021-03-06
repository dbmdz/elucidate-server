package com.digirati.elucidate.common.service;

import com.digirati.elucidate.common.infrastructure.exception.AnnotationPublisherException;
import com.digirati.elucidate.common.model.annotation.w3c.W3CAnnotation;

public interface AnnotationPublisherService {

    public void create(W3CAnnotation w3cAnnotation) throws AnnotationPublisherException;

    public void update(W3CAnnotation w3cAnnotation) throws AnnotationPublisherException;

    public void delete(W3CAnnotation w3cAnnotation) throws AnnotationPublisherException;
}
