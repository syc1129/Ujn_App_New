package com.lssl.medical.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    //加密密文，私钥
    public static final String APP_SECRET = "lssl";
    // 过期时间，单位毫秒
    public static final long EXPIRE_TIME = 60 * 60 * 1000; // 一个小时


    /**
     * 由字符串生成加密key
     */
    public static SecretKey generalKey() {
        // 本地的密码解码
        byte[] encodedKey = Base64.decodeBase64(APP_SECRET);
        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 生成token的方法
     * @param id
     * @param uname
     * @param role
     * @return
     */
    public static String getJwtToken(Long id, String uname, String role){

        //token载体（用户id和用户名）
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",id);
        claims.put("uname", uname);
        claims.put("role", role);

        //另外一种加密方式：APP_SECRET.getBytes(StandardCharsets.UTF_8)
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ","JWT")  //头信息
                .setHeaderParam("alg","HS256")
                .setSubject("medical-user")  //分类（自定义）
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256,APP_SECRET)
                .compact();
        return JwtToken;
    }

    /**
     *
     *判断token是否有效的方法
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        //加密key
        SecretKey key = generalKey();
        if(!StringUtils.hasLength(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean checkToken(HttpServletRequest request) {
        SecretKey key = generalKey();
        try {
            String jwtToken = request.getHeader("token");
            if(!StringUtils.hasLength(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        }
        catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取Claims的方法
     * @param jwtToken
     * @return
     */
    public static Claims getClaims(String jwtToken) {
        SecretKey key = generalKey();
        if(!StringUtils.hasLength(jwtToken))
            return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return claims;
    }

    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        SecretKey key = generalKey();
        String jwtToken = request.getHeader("token");
        if(!StringUtils.hasLength(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }


}
