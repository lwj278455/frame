package com.xxx.frame.Entity.Model;

import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.PlayRecord;

import java.io.Serializable;

/**
 * 观看记录实例
 */
public class PlayRecordResult implements Serializable {
    private static final long serialVersionUID = -78430140720280373L;
    private PlayRecord playRecord;
    private ClassInfo classInfo;

    public PlayRecordResult() {
    }

    public PlayRecordResult(PlayRecord playRecord, ClassInfo classInfo) {
        this.playRecord = playRecord;
        this.classInfo = classInfo;
    }


    public PlayRecord getPlayRecord() {
        return playRecord;
    }

    public void setPlayRecord(PlayRecord playRecord) {
        this.playRecord = playRecord;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
}
