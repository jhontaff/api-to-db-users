package com.users_api.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PostsDto {

        private Long id;
        private Long userId;
        private String title;
        private String body;

        public Long getId() {
            return id;
        }

        public Long getUserId() {
            return userId;
        }

        public String getTitle() {
            return title;
        }

        public String getBody() {
            return body;
        }

}
