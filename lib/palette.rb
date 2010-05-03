# Palette are the colors used in pixel art
require 'color'

class Palette
  def initialize
    @colors = []
  end
  
  def add(color)
    @colors << color
    return @colors.size - 1
  end

  def size
    return @colors.size
  end

  def get(index)
    return @colors[index]
  end


end
