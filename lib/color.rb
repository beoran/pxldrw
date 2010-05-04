# Color is a basic color as used in pixel art.
# It's represented as a 1 byte valued RGBA color space
# Is immutable.

class Color
  attr_reader :r
  attr_reader :g
  attr_reader :b
  attr_reader :a
  attr_reader :name

  OPAQUE      = 255

  # vCreates a new abstract RGBA color.
  def initialize(r, g=nil, b=nil, a = nil, name=nil)
    if g
      @r    = r
      @g    = g
      @b    = b
      @a    = a
      @name = name
    else
        @r, @g, @b, @name = *r
    end
    a ||= OPAQUE
  end

  # Transforms the color to an array of r, g, b, and a values of the color
  def to_a
    return @r, @g, @b, @a
  end

  # Allows the splat operator to be applied to color.
  # Returns r, g, b, a in that order
  def to_splat
    return @r, @g, @b, @a
  end

  # Returns true if the color is invisible, false if not
  def transparent?
    return @a == 0
  end

  # Returns true if the color is visible, false if not
  def opaque?
    return @a > 0
  end


end
