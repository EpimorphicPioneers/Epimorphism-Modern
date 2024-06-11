package com.epimorphismmc.epimorphism.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.StringReader;

public class EPTransformUtil {

    public static final Gson GSON = new Gson();

    //  Entity
    public static String entityToString(Entity entity) {
        return EntityType.getKey(entity.getType()).toString();
    }

    public static Entity stringToEntity(
            @NotNull String key, @NotNull Level level, CompoundTag compoundTag, boolean withTag) {
        Entity entity = EntityType.byString(key)
                .filter(EntityType::canSummon)
                .map(type -> level.isClientSide() ? null : type.create(level))
                .orElse(null);

        if (entity != null && withTag) {
            entity.load(compoundTag);
        }

        return entity;
    }

    // Json
    public static JsonElement fromString(@Nullable String string) {
        if (string != null && !string.isEmpty() && !string.equals("null")) {
            try {
                JsonReader jsonReader = new JsonReader(new StringReader(string));
                boolean lenient = jsonReader.isLenient();
                jsonReader.setLenient(true);
                JsonElement element = Streams.parse(jsonReader);
                if (!element.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("Did not consume the entire document.");
                } else {
                    return element;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                return JsonNull.INSTANCE;
            }
        } else {
            return JsonNull.INSTANCE;
        }
    }
}
