package com.example.service;

import com.example.model.TeacherLesson;


import java.util.List;

public interface TeacherLessonService {
    TeacherLesson addTeacherLesson(TeacherLesson teacherLesson);
    void delete(TeacherLesson teacherLesson);
    TeacherLesson getById(Long id);
    List<TeacherLesson> getAllTeacherLesson();
    TeacherLesson updateUser(TeacherLesson teacherLesson);
}
