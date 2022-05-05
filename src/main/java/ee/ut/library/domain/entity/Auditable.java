package ee.ut.library.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
    @CreatedBy
    @Column(updatable = false)
    protected UUID createdBy;
    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    protected Date createdAt;
    @LastModifiedBy
    protected UUID modifiedBy;
    @UpdateTimestamp
    protected Date modifiedAt;
}
