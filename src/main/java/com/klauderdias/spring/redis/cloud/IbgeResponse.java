package com.klauderdias.spring.redis.cloud;

import java.io.Serializable;

public record IbgeResponse(int id, String nome) implements Serializable {
}

