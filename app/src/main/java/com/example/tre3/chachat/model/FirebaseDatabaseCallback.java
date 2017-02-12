package com.example.tre3.chachat.model;

import java.util.List;

/**
 * Created by Tre3 on 2017/02/12.
 */

public interface FirebaseDatabaseCallback {

    void notifyFriendListUpdate(List<String> friendList);
}
