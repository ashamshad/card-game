package com.cardgame.doublesir.serializer;

import com.cardgame.doublesir.dto.Card;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Custom serializer to serialize enum attributes.
 */
public class CardSerializer extends JsonSerializer<Card> {

    @Override
    public void serialize(Card card, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("id");
        jsonGenerator.writeString(card.name());
        jsonGenerator.writeFieldName("mark");
        jsonGenerator.writeNumber(card.getMark());
        jsonGenerator.writeFieldName("suit");
        jsonGenerator.writeString(card.getSuit().name());
        jsonGenerator.writeEndObject();
    }
}
