/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.andrew.kmakaew;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karinya
 */
@Entity
@Table(name = "APP.STUDENTTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studenttable.findAll", query = "SELECT s FROM Studenttable s"),
    @NamedQuery(name = "Studenttable.findByStudentId", query = "SELECT s FROM Studenttable s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Studenttable.findByStudentName", query = "SELECT s FROM Studenttable s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "Studenttable.findByScholarshipAmount", query = "SELECT s FROM Studenttable s WHERE s.scholarshipAmount = :scholarshipAmount")})
public class Studenttable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENT_ID")
    private Short studentId;
    @Size(max = 40)
    @Column(name = "STUDENT_NAME")
    private String studentName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SCHOLARSHIP_AMOUNT")
    private Double scholarshipAmount;

    public Studenttable() {
    }

    public Studenttable(Short studentId) {
        this.studentId = studentId;
    }

    public Short getStudentId() {
        return studentId;
    }

    public void setStudentId(Short studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(Double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studenttable)) {
            return false;
        }
        Studenttable other = (Studenttable) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmu.andrew.kmakaew.Studenttable[ studentId=" + studentId + " ]";
    }
    
}
