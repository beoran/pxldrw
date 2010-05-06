# A stroke is any action that was applied to the pixel art that altered it.
# Mre specifially, strokes are modifications applied to the Grid the pixel art
# is drawn in.
#
# Strokes may be dots, lines, rectangles, circles, blobs from floodfill, etc...
# A stroke can either add or remove pixel, that is, a stroke can be
# like a stroke from a pencil, or like a stroke from an eraser.
#
# Since we are dealing with pixel art, a stroke has but a single color, or
# uses the :erase syymbol to indicate an erasing stroke.
# Erssing strokes remember the values of all pixels they erased.
#
# All kinds of strokes are immutable after construction.


class Stroke
  attr_reader :color

  def initialize(color)
    @color  = color
    @erased = []
  end

  # Draws itself onto a Grid
  def draw(grid)
    # Default stroke does nothing
    return
  end
end



