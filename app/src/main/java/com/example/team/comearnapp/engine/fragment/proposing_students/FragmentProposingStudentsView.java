package com.example.team.comearnapp.engine.fragment.proposing_students;

import com.example.team.comearnapp.entity.PersonInfo;
import com.example.team.comearnlib.base.mvp_mode.base_view.IBaseView;

import java.util.ArrayList;

/**
 * Created by Ellly on 2018/2/20.
 */

public interface FragmentProposingStudentsView extends IBaseView {
    void updateList(ArrayList<PersonInfo> list);
    void presentLoading();
    void stopLoading();
}
