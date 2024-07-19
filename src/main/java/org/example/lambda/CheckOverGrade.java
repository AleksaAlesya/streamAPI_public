package org.example.lambda;

// такой класс лучше не использовать, лучше анонимный
public class CheckOverGrade implements StudentCheck
{
    @Override
    public boolean check(Student s) {

        return s.avgGrade>5;
    }
}
