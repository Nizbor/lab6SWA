package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lesson", schema = "task2")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id_lesson", nullable = false)
    private Long id_lesson;

    @Column (name = "name_lesson", length = 255)
    private String NameLesson;

    public Lesson(String NameLesson, long id_lesson){
        this.NameLesson = NameLesson;
        this.id_lesson = id_lesson;
    }

    public Lesson() {

    }

    public long getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(long id_lesson) {
        this.id_lesson = id_lesson;
    }

    public String getNameLesson() {
        return NameLesson;
    }

    public void setNameLesson(String nameLesson) {
        NameLesson = nameLesson;
    }

    @Override
    public  String toString(){
        return "model.Lesson{" + "NameLesson: " + NameLesson + "}";
    }
}
