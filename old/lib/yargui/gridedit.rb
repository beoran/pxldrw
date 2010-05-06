# To change this template, choose Tools | Templates
# and open the template in the editor.

require 'java'


module Yargui

  class Color < Awt::Color
  end

  class Dimension < Awt::Dimension
  end

  class BufferedImage < Awt::BufferedImage
  end

  class GradientPaint < Awt::GradientPaint
  end

  

  
  class Gridedit < Swing::JComponent
    include Yargui::Awt::MouseMotionListener

    include Wrapper
    # include Mouse::Adapter
    # include Action::Adapter

    UI_CLASS_ID = "GridEditUI";

    attr_reader   :wide
    attr_reader   :high
    attr_reader   :zoom
    attr_accessor :lines



    # Initializes the Gird editor with a grid model.
    def initialize(gridmodel, zoom=10)
      super()
      @zoom   = zoom   # Zoom factor
      @lines  = false # draw the grid lines or not?
      @color  = Color.new(255,255,255)
      # Color to draw the grid with
      @back1  = Color.new(64,64,64)
      @back2  = Color.new(127,127,127)
      # Background colors of grid
      self.setBackground(@back)
      self.grid = gridmodel
      self.addMouseMotionListener(self)
    end

    # Draws self to the bitmap backbuffer
    def draw_buffered()
      g  = @buffer.createGraphics()
      paint_background(g)
      paint_grid(g)
      g.dispose()
    end

    # Changes the grid model assoicated with this editor
    def grid=(grid)
      @grid   = grid # the grid we're editing
      if @grid
        update
      end
    end
    
    # Changes the zoom factor for this grid editor
    def zoom=(zoom)
      @zoom = zoom
      update
    end

    # Called when the grid or zoom changes
    def update
      @wide   = @grid.wide * @zoom
      @high   = @grid.high * @zoom
      @dim    = Dimension.new(@wide, @high)
      self.setMinimumSize(@dim)
      self.setSize(@wide, @high)
      self.setMaximumSize(@dim )
      @buffer = BufferedImage.new(@wide, @high, BufferedImage::TYPE_INT_RGB)
      
    end

    def update_drawing
      draw_buffered()
    end

    def paintComponent(g)       
       # super(g)
       # g.drawImage(@buffer, 0, 0, nil)
       # paint_background(g)
       paint_grid(g)
       g.dispose()
    end

    # Paints the background color
    def paint_background(g)
      g.setPaint(@back1)
      g.fillRect(0, 0, @wide, @high)
    end

    # Paints the grid's contents if it's not nil
    def paint_grid(g)
      y     = 0
      ydex  = 0
      while ydex < @grid.high
        xdex = 0
        x = 0
        while xdex < @grid.wide
          pixel = @grid.get(xdex, ydex)
          if pixel && pixel.opaque?
            paint = Yargui::Color.new(*pixel)
          else paint # Invisible or empty pixels. Indicate them with a gradient.
            paint = GradientPaint.new(x , y, @back1, x + @zoom, y  + @zoom, @back2)
          end
          g.setPaint(paint)
          g.fillRect(x, y , @zoom, @zoom)

          if @lines # draw the grid outlines if needed
            g.setPaint(@color)
            g.drawRect(x, y , @zoom, @zoom)          
          end
          x += @zoom
          xdex += 1
        end
        y += @zoom
        ydex   += 1
      end
    end

    def getUIClassID()
      return UI_CLASS_ID
    end

    def mouseDragged(e)
      color = ::Color.new(255, 255, 255, 255, :white)
      @grid.put(e.getX() / @zoom, e.getY() / @zoom, color);
      self.repaint()
    end

    def mouseMoved(mouse_event)
    end


  end
end
