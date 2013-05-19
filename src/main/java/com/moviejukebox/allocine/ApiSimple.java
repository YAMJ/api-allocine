package com.moviejukebox.allocine;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class NewApi {

    private static String mainPartnerKey = "100043982026";
    private static String mainSecretKey = "29d185d98c984a359e6e6f26a0474269";
    private static Map<String, String> ids = new LinkedHashMap<String, String>();

    public static void main(String[] args) {
        AllocineApi api = new AllocineApi(mainPartnerKey, mainSecretKey);

        ids.put("197440", "Adieu Berthe ou l'enterrement de mémé");
        ids.put("54343", "L'Odyssée de Pi");
        ids.put("45866", "Salut Berthe!");
        ids.put("136190", "Iron Man 2");

        for (Map.Entry<String, String> entry : ids.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " Title '" + entry.getValue() + "' URL: " + api.get(entry.getKey()));
        }
//        System.out.println("SEARCH RESPONSE: " + api.search("Avatar"));
    }

    private static class AllocineApi {

        private static final String API_URL = "http://api.allocine.fr/rest/v3/";
        private static final String userAgent = "Dalvik/1.6.0 (Linux; U; Android 4.2.2; Nexus 4 Build/JDQ39E)";
        private String partnerKey;
        private String secretKey;
        private static final String METHOD_MOVIE = "movie";
        private static final String METHOD_SEARCH = "search";

        public AllocineApi(String partnerKey, String secretKey) {
            this.partnerKey = partnerKey;
            this.secretKey = secretKey;
        }

        public String createUrl(final String method, final Map<String, String> params) {
            // https://github.com/gromez/allocine-api/blob/master/PHP/allocine.class.php

            /*

             SED  : 20130508
             toEnc: 29d185d98c984a359e6e6f26a0474269partner=100043982026&code=27405&profile=large&filter=movie&striptags=synopsis%2Csynopsisshort&format=json&sed=20130508
             SHA1HEX: d0a8a10ed7259a6b8f5a8b766dfd757c807cc8f6
             SHA1 : Ð¨¡×%kZvmýu||Èö
             BASE : 0KihDtclmmuPWot2bf11fIB8yPY=
             SIG  : 0KihDtclmmuPWot2bf11fIB8yPY%3D
             Query: http://api.allocine.fr/rest/v3/movie?partner=100043982026&code=27405&profile=large&filter=movie&striptags=synopsis%2Csynopsisshort&format=json&sed=20130508&sig=0KihDtclmmuPWot2bf11fIB8yPY%3D

             */
            /*
             2Enc: 29d185d98c984a359e6e6f26a0474269partner=100043982026&code=27405&profile=large&filter=movie&striptags=synopsis%2Csynopsisshort&format=json&sed=20130508
             SHA1: Ð¨¡×%šk?Z‹vmýu|€|Èö
             SHA1HEX: d0a8a10ed7259a6b8f5a8b766dfd757c807cc8f6
             BASE: 0KihDtclmmuPWot2bf11fIB8yPY=
             SIG : 0KihDtclmmuPWot2bf11fIB8yPY%3D
             SED : 20130508
             URL:   http://api.allocine.fr/rest/v3/movie?partner=100043982026&code=27405&profile=large&filter=movie&striptags=synopsis%2Csynopsisshort&format=json&sed=20130508&sig=[B@611c048e
             Query: http://api.allocine.fr/rest/v3/movie?partner=100043982026&code=27405&profile=large&filter=movie&striptags=synopsis%2Csynopsisshort&format=json&sed=20130508&sig=0KihDtclmmuPWot2bf11fIB8yPY%3D
             */



            String sed = buildSed();
            String paramUrl = buildParams(params);

            String toEnc = secretKey + paramUrl + "&sed=" + sed;
            byte[] sha1code = DigestUtils.sha1(toEnc);

            String b64 = new String(Base64.encodeBase64(sha1code));
            String sig = encoder(b64);

//            System.out.println("2Enc: " + toEnc);
//            System.out.println("SHA1: " + new String(sha1code));
//            System.out.println("SHA1HEX: " + DigestUtils.sha1Hex(toEnc));
//            System.out.println("BASE: " + b64);
//            System.out.println("SIG : " + sig);
//            System.out.println("SED : " + sed);

            StringBuilder url = new StringBuilder(API_URL);
            url.append(method);
            url.append("?").append(paramUrl);
            url.append("&sed=").append(sed);
            url.append("&sig=").append(sig);

//            System.out.println("URL: " + url.toString());
            return url.toString();

        }

        private String encoder(String toEncode) {
            try {
                return URLEncoder.encode(toEncode, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                System.out.println("Failed to encode: " + ex.getMessage());
                return "";
            }
        }

        private String buildSed() {
            DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return sdf.format(new Date());
        }

        private String buildParams(final Map<String, String> params) {
            StringBuilder paramUrl = new StringBuilder();
            boolean first = Boolean.TRUE;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (first) {
                    first = Boolean.FALSE;
                } else {
                    paramUrl.append("&");
                }
                paramUrl.append(entry.getKey()).append("=").append(encoder(entry.getValue()));
            }
            return paramUrl.toString();
        }

        public String get(String id) {
            Map<String, String> params = new LinkedHashMap<String, String>();
            params.put("partner", partnerKey);
            params.put("code", id);
            params.put("profile", "large");
            params.put("filter", "movie");
            params.put("striptags", "synopsis,synopsisshort");
            params.put("format", "json");

            return createUrl(METHOD_MOVIE, params);
        }

        public String search(String query) {
            Map<String, String> params = new LinkedHashMap<String, String>();
            params.put("partner", partnerKey);
            params.put("q", query);
            params.put("format", "json");
            params.put("filter", "movie");

            return createUrl(METHOD_SEARCH, params);
        }
    }
}