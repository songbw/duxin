package com.jiannei.duxin.dto;

public enum SystemStatus {

    OK(200, "success"),
    // 500- 服务器错误
    SERVER_ERROR(500, "Server exception"),
    // 400- 请求错误
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "参数不匹配"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    UNSUPPORTED_TEL(50001, "手机号已经存在"),
    SEND_ERROR(50002, "验证码发送失败"),
    USERNAME_IS_NULL(50003, "用户名不能为空"),
    PASSWORD_IS_NULL(50004, "密码不能为空"),
    USERNAME_PASSWORD_IS_ERROR(50005, "登录失败，请检查用户名或密码！"),
    USERNAME_EXIST(50006, "用户名重复"),
    UUIMS_ERROR(60001, "请求认证服务器出错"),
    ID_NOT_FOUND(400001, "请求参数不匹配"),
    TOKEN_TIME_OUT(600002, "登录过期,请重新登录"),
    FOTA_IS_EXIT(700003, "FOTA已经存在，请修改后重新上传"),
    MCU_IS_EXIT(700004, "MCU已经存在，请修改后重新上传"),
    MCU_NO_INSERT(700005, "MCU原版本不能相同，请修改后重新上传"),
    MCU_NO_DEST(700006, "MCU目标版本不能相同，请修改后重新上传"),
    DICT_NO_INSERT(80001,"字典类型key不能相同，请修改后重新提交"),
    DICT_NO_DELETE(80002,"该字典被引用，请修改后重新提交"),
    MENU_NO_INSERT(80003,"菜单类型key不能相同，请修改后重新提交"),
    MENU_NO_DELETE(80004,"该菜单被引用，请修改后重新提交"),
    MENU_NO_PARENT_DELETE(80005,"该菜单下有子菜单，请修改后重新提交");
    SystemStatus(int status, String str) {
        setCode(status);
        setStr(str);
    }

    /*  public SystemStatus newStatus(int status, String str){

      }*/
    private int code;

    private String str;

    public int getCode() {
        return code;
    }

    public String getStr() {
        return str;
    }

    private void setCode(int code) {
        this.code = code;
    }

    private void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("code");
        sb.append(":");
        sb.append(code);
        sb.append(",");
        sb.append("message");
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

}
