package com.cardgame.doublesir.serializer;

import com.cardgame.doublesir.dto.Card;
import com.cardgame.doublesir.dto.Game;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Custom serializer to serialize enum attributes.
 */
public class GameSerializer extends JsonSerializer<Game> {

    @Override
    public void serialize(Game game, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString(game.getName());
        jsonGenerator.writeFieldName("players");
        jsonGenerator.writeObject(game.getPlayers());
        jsonGenerator.writeEndObject();
    }
}
