package com.wf.mn.login.bean;

/**
 * @author : wf
 * @time : 2020-11-12-14:07
 */
public class RegiestBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiZWU5OTc1ODMtNzgzNi00NGI3LWExZTMtZGZhOWM1ZjljMmY3IiwiaWF0IjoxNjA1MTQ3MzY1fQ.JI9et2F5JhONZBoWGdVNqYIAYYL7GiAqVx7WqT4Sfdk","userInfo":{"uid":"ee997583-7836-44b7-a1e3-dfa9c5f9c2f7","username":"shouyiren1","nickname":null,"gender":0,"avatar":"","birthday":0}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiZWU5OTc1ODMtNzgzNi00NGI3LWExZTMtZGZhOWM1ZjljMmY3IiwiaWF0IjoxNjA1MTQ3MzY1fQ.JI9et2F5JhONZBoWGdVNqYIAYYL7GiAqVx7WqT4Sfdk
         * userInfo : {"uid":"ee997583-7836-44b7-a1e3-dfa9c5f9c2f7","username":"shouyiren1","nickname":null,"gender":0,"avatar":"","birthday":0}
         */

        private String token;
        private UserInfoBean userInfo;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * uid : ee997583-7836-44b7-a1e3-dfa9c5f9c2f7
             * username : shouyiren1
             * nickname : null
             * gender : 0
             * avatar :
             * birthday : 0
             */

            private String uid;
            private String username;
            private Object nickname;
            private int gender;
            private String avatar;
            private int birthday;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getBirthday() {
                return birthday;
            }

            public void setBirthday(int birthday) {
                this.birthday = birthday;
            }
        }
    }

    /**
     * {
     *     "errno": 0,
     *     "errmsg": "",
     *     "data": {
     *         "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiZWU5OTc1ODMtNzgzNi00NGI3LWExZTMtZGZhOWM1ZjljMmY3IiwiaWF0IjoxNjA1MTQ3MzY1fQ.JI9et2F5JhONZBoWGdVNqYIAYYL7GiAqVx7WqT4Sfdk",
     *         "userInfo": {
     *             "uid": "ee997583-7836-44b7-a1e3-dfa9c5f9c2f7",
     *             "username": "shouyiren1",
     *             "nickname": null,
     *             "gender": 0,
     *             "avatar": "",
     *             "birthday": 0
     *         }
     *     }
     * }
     */


}
