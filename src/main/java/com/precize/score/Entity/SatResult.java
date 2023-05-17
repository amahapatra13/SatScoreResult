package com.precize.score.Entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name="sat_result")
public class SatResult {

    @Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    private String name;

    public Long getStudentId() {
        return studentId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_city")
    private Address address;

    private Integer satScore;

    private boolean passed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getSatScore() {
        return satScore;
    }

    public void setSatScore(Integer satScore) {
        this.satScore = satScore;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed() {

        int score = (this.satScore/1600) * 100;

        if(score <= 30){
         this.passed = false;
        }else{
            this.passed = true;
        }
    }

    public SatResult() {
    }
}
