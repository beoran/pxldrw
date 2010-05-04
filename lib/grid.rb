# All pixel art is drawn using a specific, well defined grid.
# Pixel art is clean in tah tit does not allow any half pixel effects.
# The Grid class models the twodimensional grid that the pixel art is drawn on.
# Grid class is mutable for memory efficiency.

class Grid
  # Width of the grid
  attr_reader :wide
  # Height of the grod
  attr_reader :high

  # Pixels of the grid, in [y][x] format
  attr_reader :pixels

  def initialize(wide, high)
    @wide   = wide
    @high   = high
    @pixels = Array.new(@high) do
        Array.new(@wide, nil)
    end
  end

  # Checks if x or y are out of bounds
  def out_of_bounds?(x, y)
    return true if x >= self.wide
    return true if x < 0
    return true if y >= self.high
    return true if y < 0
    return false
  end

  # Gets a pixel from the x and y cooordinates.
  # Returns nil if x or y is out of bounds
  def get(x, y)
    return nil if out_of_bounds?(x, y)
    return @pixels[y][x]
  end


  # Puts a pixel at the given x and y cooordinates with the given color
  # Returns the color set, or nil if  x or y are out of bounds
  def put(x, y, color)
    return nil if out_of_bounds?(x, y)
    @pixels[y][x] = color
    return color
  end


end
