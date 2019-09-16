package com.xxx.frame.Entity.Wechat;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xxx.frame.Annotation.XStreamCDATA;

public class MediaIdMessage {
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}
