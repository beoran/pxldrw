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

  def to_a
    return @r, @g, @b
  end

  def transparent?
    return @a == 0
  end


end
