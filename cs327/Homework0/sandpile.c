#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define MAX_HEIGHT 8
#define DEFAULT_FPS 60

#define USE_COLOR 1

#define CYAN    "\033[36m"
#define YELLOW  "\033[33m"
#define GREEN   "\033[32m"
#define BLUE    "\033[34m"
#define MAGENTA "\033[35m"
#define RED     "\033[31m"

#define SIDE 23
#define QUEUE_SIZE 500 /* Don't know how big is "big enough", but don't *
                        * want to use a dynamic structure.  Instead,    *
                        * print an error message and terminate if we    *
                        * run out of space.                             */

signed char pile[SIDE][SIDE];
unsigned queue[QUEUE_SIZE][2];
unsigned queue_head = QUEUE_SIZE - 1, queue_tail = 0;

#define start_color(x)     \
if (USE_COLOR) {           \
  fwrite(x, 1, 5, stdout); \
}

#define end_color()                \
if (USE_COLOR) {                   \
  fwrite("\033[0m", 1, 5, stdout); \
}

void queue_cell(unsigned y, unsigned x) {
  if (queue_head == queue_tail) {
    fprintf(stderr, "Queue is full.  Terminating.\n");
    exit(1);
  }

  queue[queue_tail][0] = y;
  queue[queue_tail][1] = x;

  if (++queue_tail == QUEUE_SIZE) {
    queue_tail = 0;
  }

}

int dequeue_cell(unsigned *y, unsigned *x) {
  if ((queue_head + 1) % QUEUE_SIZE == queue_tail) {
    return 1; /* queue is empty */
  }

  if (++queue_head == QUEUE_SIZE) {
    queue_head = 0;
  }

  *y = queue[queue_head][0];
  *x = queue[queue_head][1];

  return 0;
}

int main(int argc, char *argv[])
{
  unsigned y, x;
  unsigned i, s;
  int fps = DEFAULT_FPS;
  int delay;

  if (argc != 1 && !strcmp(argv[1], "--fps")) {
    fps = atoi(argv[2]);
    i = 3;
  } else {
    i = 1;
  }

  delay = 1000000 / fps;

  for (; i < argc; i += 3) {
    s = atoi(argv[i + 2]);
    pile[atoi(argv[i])][atoi(argv[i + 1])] = (s ? s : -1);
  }

  for (;;) {
    y = x = SIDE / 2;
    if ((++pile[y][x]) > MAX_HEIGHT) {
      pile[y][x] -= MAX_HEIGHT;
      queue_cell(y, x);
    }
    while (!dequeue_cell(&y, &x)) {
      /*      printf("Tumbling (%d,%d)\n", y, x);*/
      if (y && pile[y - 1][x] != -1 && ((++pile[y - 1][x]) > MAX_HEIGHT)) {
	pile[y - 1][x] -= MAX_HEIGHT;
	queue_cell(y - 1, x);
      }
      if (y && x && pile[y - 1][x - 1] != -1 &&
          ((++pile[y - 1][x - 1]) > MAX_HEIGHT)) {
	pile[y - 1][x - 1] -= MAX_HEIGHT;
	queue_cell(y - 1, x - 1);
      }
      if ((y < SIDE - 1) && pile[y + 1][x] != -1 &&
          ((++pile[y + 1][x]) > MAX_HEIGHT)) {
	pile[y + 1][x] -= MAX_HEIGHT;
	queue_cell(y + 1, x);
      }
      if ((y < SIDE - 1) && (x < SIDE - 1) &&
          pile[y + 1][x + 1] != -1 && ((++pile[y + 1][x + 1]) > MAX_HEIGHT)) {
	pile[y + 1][x + 1] -= MAX_HEIGHT;
	queue_cell(y + 1, x + 1);
      }
      if (x && pile[y][x - 1] != -1 && ((++pile[y][x - 1]) > MAX_HEIGHT)) {
	pile[y][x - 1] -= MAX_HEIGHT;
	queue_cell(y, x - 1);
      }
      if ((y < SIDE - 1) && x &&
          pile[y + 1][x - 1] != -1 && ((++pile[y + 1][x - 1]) > MAX_HEIGHT)) {
	pile[y + 1][x - 1] -= MAX_HEIGHT;
	queue_cell(y + 1, x - 1);
      }
      if ((x < SIDE - 1) && pile[y][x + 1] != -1 &&
          ((++pile[y][x + 1]) > MAX_HEIGHT)) {
	pile[y][x + 1] -= MAX_HEIGHT;
	queue_cell(y, x + 1);
      }
      if (y && (x < SIDE - 1) && pile[y - 1][x + 1] != -1 &&
          ((++pile[y - 1][x + 1]) > MAX_HEIGHT)) {
	pile[y - 1][x + 1] -= MAX_HEIGHT;
	queue_cell(y - 1, x + 1);
      }
    }

    putc('\n', stdout);
    for (y = 0; y < SIDE; y++) {
      for (x = 0; x < SIDE; x++) {
	switch(pile[y][x]) {
        case -1:
          start_color(CYAN);
          break;
	case 0:
	  start_color(YELLOW);
	  break;
	case 1:
	case 2:
	  start_color(GREEN);
	  break;
	case 3:
	case 4:
	  start_color(BLUE);
	  break;
	case 5:
	case 6:
	  start_color(MAGENTA);
	  break;
	case 7:
	case 8:
	  start_color(RED);
	  break;
	}
        if (pile[y][x] == -1) {
          putc('#', stdout); /* A sink */
        } else {
          putc(pile[y][x] + '0', stdout);
        }
      }
      if (y == 0) {
        end_color();
      }
      putc('\n', stdout);
    }

    usleep(delay);
  }

  return 0;
}
