package com.example.team.comearnapp.engine.fragment.proposing_students;

import com.example.team.comearnapp.entity.PersonInfo;
import com.example.team.comearnlib.base.mvp_mode.base_model.BaseModel;

import java.util.ArrayList;

/**
 * Created by Ellly on 2018/2/20.
 */

public class FragmentProposingStudentsModel extends BaseModel {
    public ArrayList<PersonInfo> receiveQuitRequests(){
        ArrayList<PersonInfo> personInfos = new ArrayList<>();
        personInfos.add(new PersonInfo().setName("邹神"));
        personInfos.add(new PersonInfo().setName("邹神"));
        personInfos.add(new PersonInfo().setName("邹神"));
        personInfos.add(new PersonInfo().setName("邹神"));
        personInfos.add(new PersonInfo().setName("邹神"));
        return personInfos;
    }
}