package com.fuzs.aquaacrobatics.entity;

@SuppressWarnings("unused")
public class EntitySize {

    public final float width;
    public final float height;
    public final boolean fixed;

    public EntitySize(float widthIn, float heightIn, boolean fixedIn) {

        this.width = widthIn;
        this.height = heightIn;
        this.fixed = fixedIn;
    }

    public EntitySize scale(float factor) {

        return this.scale(factor, factor);
    }

    public EntitySize scale(float widthFactor, float heightFactor) {

        return !this.fixed && (widthFactor != 1.0F || heightFactor != 1.0F) ? flexible(this.width * widthFactor, this.height * heightFactor) : this;
    }

    public static EntitySize flexible(float widthIn, float heightIn) {

        return new EntitySize(widthIn, heightIn, false);
    }

    public static EntitySize fixed(float widthIn, float heightIn) {

        return new EntitySize(widthIn, heightIn, true);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {

            return true;
        } else if (obj instanceof EntitySize) {

            return this.width == ((EntitySize) obj).width && this.height == ((EntitySize) obj).height;
        }

        return false;
    }

    @Override
    public String toString() {

        return "EntityDimensions w=" + this.width + ", h=" + this.height + ", fixed=" + this.fixed;
    }

}
