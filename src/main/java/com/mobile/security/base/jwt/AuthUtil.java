package com.mobile.security.base.jwt;

import com.mobile.security.utils.ToolUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 張燿峰
 * <p>Jwt工具类</p>
 * jwt的claim里一般包含以下几种数据:
 * 1. iss -- token的发行者
 * 2. sub -- 该JWT所面向的用户
 * 3. aud -- 接收该JWT的一方
 * 4. exp -- token的失效时间
 * 5. nbf -- 在此时间段之前,不会被处理
 * 6. iat -- jwt发布时间
 * 7. jti -- jwt唯一标识,防止重复使用
 *
 * @author 孤
 * @date 2019/1/2
 * @Varsion 1.0
 */
public class AuthUtil {

    /**
     * 从Token中获取用户名称
     *
     * @param token
     * @return 用户名称
     */
    public static String getUserNameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    /**
     * 从Token中获取JWT发布时间
     *
     * @param token
     * @return 发布时间
     */
    public static Date getIsseudAtDateFromToken(String token) {
        return getClaimsFromToken(token).getIssuedAt();
    }

    /**
     * 从Token中获取JWT过期时间
     *
     * @param token
     * @return 过期时间
     */
    public static Date getExPirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    /**
     * 从Token中获取JWT接收者
     *
     * @param token
     * @return 接收者
     */
    public static String getAyduebceFromToken(String token) {
        return getClaimsFromToken(token).getAudience();
    }

    /**
     * 从Token中获取私有的JWT claim
     *
     * @param token
     * @param key
     * @return claim
     */
    public static String getPrivateClaimsFromToken(String token, String key) {
        return getClaimsFromToken(token).get(key).toString();
    }

    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(JwtConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 检查Token是否正确
     *
     * @param token
     */
    public static void parseToken(String token) {
        Jwts.parser().setSigningKey(JwtConstants.SECRET).parseClaimsJws(token).getBody();
    }

    /**
     * 检查Token是否过期
     *
     * @param token
     * @return false未过期  true过期
     */
    public static boolean isTokenExpired(String token) {
        try {
            final Date expiration = getExPirationDateFromToken(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    /**
     * 生成Token
     *
     * @param corpId
     * @return Token
     */
    public static String generateToken(String corpId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("corpId", corpId);
        return doGeneratorToken(claims, corpId);
    }

    private static String doGeneratorToken(Map<String, Object> claims, String subject) {
        final Date startDate = new Date();
        final Date endDate = new Date(startDate.getTime() + JwtConstants.EXPIRATION * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(startDate)
                .setExpiration(endDate)
                .signWith(SignatureAlgorithm.HS512, JwtConstants.SECRET)
                .compact();
    }

    /**
     * 获取混淆MD5签名用的随机字符串
     */
    public static String getRandomKey() {
        return ToolUtils.getRandomString(6);
    }
}

