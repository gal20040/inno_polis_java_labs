package ItP.UniversityInformationSystem;

import java.util.ArrayList;

/**
 * Created by vasya on 24.08.2016.
 */
public class Solution {
    public static void main(String[] args) {
//        LectureCourse listOfLectureCourse;
        ArrayList<LectureCourse> listOfLectureCourse = new ArrayList<LectureCourse>();

        listOfLectureCourse.add(new LectureCourse("DMD"));
        listOfLectureCourse.add(new LectureCourse("DSA"));
        listOfLectureCourse.add(new LectureCourse("ItP"));

        System.out.println(listOfLectureCourse.get(1).title);
    }
}