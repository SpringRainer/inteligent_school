package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class grade_all_information implements Serializable {
    private Integer chinese;
    private Integer math;
    private Integer english;
    private Integer physics;
    private Integer chemistry;
    private Integer biology;
    private Integer geography;
    private Integer politics;
    private Integer history;

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    public Integer getChemistry() {
        return chemistry;
    }

    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    public Integer getBiology() {
        return biology;
    }

    public void setBiology(Integer biology) {
        this.biology = biology;
    }

    public Integer getGeography() {
        return geography;
    }

    public void setGeography(Integer geography) {
        this.geography = geography;
    }

    public Integer getPolitics() {
        return politics;
    }

    public void setPolitics(Integer politics) {
        this.politics = politics;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }
}
